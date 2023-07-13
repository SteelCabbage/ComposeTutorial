# JetpackCompose

[TOC]

## Java环境

1. 首次sync过程中不要开自己的vpn
2. 下载jdk17

```kotlin
id 'com.android.application' version '8.0.2'
```

>需要jdk17
>
>https://www.oracle.com/java/technologies/downloads/#jdk17-mac





## 官方文档

> https://developer.android.google.cn/jetpack/compose/documentation?hl=zh-cn

1. Compose，用于构建**原生 Android 界面**的新款工具包，一个**声明性**界面框架；不同于传统的View体系（命令式更新）
2. 不依赖Android版本，**独立更新**，以及**预览功能**的支持



### Compose 中的开发者工效学设计

> https://developer.android.google.cn/jetpack/compose/ergonomics?hl=zh-cn





## 概念

### 可组合函数 `@Composable`

1. 所有可组合函数都必须带有此注释；此注释可告知 Compose 编译器：此函数旨在将数据转换为界面
2. **可组合函数只能从其他可组合函数调用；**可组合函数通过调用其他可组合函数来发出界面层次结构
3. 此函数不会返回任何内容。发出界面的 Compose 函数不需要返回任何内容，因为它们描述所需的屏幕状态，而不是构造界面 widget
4. 在 Compose 的声明性方法中，widget 相对无状态，并且不提供 setter 或 getter 函数。实际上，**widget 不会以对象形式提供**

5. 带@Composable的函数

> 当无返回值，即Unit，方法名首字母大写

```
@Composable
private fun BottomBar(selected: Int) {}
```



### 重组

> 可组合函数可以使用 `remember` 将本地状态存储在内存中，并跟踪传递给 `mutableStateOf` 的值的变化。该值更新时，系统会自动重新绘制使用此状态的可组合项（及其子项）。这称为[重组](https://developer.android.google.cn/jetpack/compose/mental-model?hl=zh-cn#recomposition)。



**智能重组**

> https://developer.android.google.cn/jetpack/compose/lifecycle?hl=zh-cn



**提升状态的场景（重要）**

> https://developer.android.google.cn/jetpack/compose/state-hoisting?hl=zh-cn



**遵循最佳实践（重要）**

> https://developer.android.google.cn/jetpack/compose/performance/bestpractices?hl=zh-cn



## 预览`@Preview`

### 默认

```kotlin
@Preview(showBackground = true)
```



### 常用属性

```kotlin
@Preview(showBackground = true, backgroundColor = 0xff00FFFF, showSystemUi = true)
```



## 常用UI

### Which Compose API to use

> https://www.jetpackcompose.app/What-is-the-equivalent-of-EditText-in-Jetpack-Compose



### Text()

1. **Compose 布局中的固有特性测量**

> https://developer.android.google.cn/jetpack/compose/layouts/intrinsic-measurements?hl=zh-cn



2. **weight的使用**

> 当Text内容过长时，会将同排的控件挤出屏幕外，这时可以将Text的weight设置为1，这样父项将未加权的子项测量完后，将剩余空间用来权重分配



### Image()



### Icon()

```kotlin
Icon(bitmap = ImageBitmap.imageResource(id = R.drawable.ic_wechat), contentDescription = title)
Icon(painter = painterResource(id = resId), contentDescription = title)
Icon(imageVector = ImageVector.vectorResource(id = resId), contentDescription = title)
```



> icon图片总为黑色？与tint模式有关，默认LocalContentColor.current，改为Color.Unspecified即可

```
Icon(bitmap = ImageBitmap.imageResource(id = R.drawable.ic_wechat), contentDescription = title, tint = Color.Unspecified)
```



### Button(): Material风格的按钮



### TextField(): EditText



### `Column()`, `Row()`: LinearLayout

1. Arrangement

> https://developer.android.google.cn/reference/kotlin/androidx/compose/foundation/layout/Arrangement



### Box(): FrameLayout, RelativeLayout





### ConstraintLayout

1. 文档：

> https://developer.android.google.cn/jetpack/compose/layouts/constraintlayout?hl=zh-cn

2. 依赖

```kotlin
implementation "androidx.constraintlayout:constraintlayout-compose:1.0.1"
```

3. tips：

> 引导线：考虑使用 `Spacer` 可组合项，以实现与 `Rows` 和 `Columns` 类似的效果

> 屏障线：考虑使用[固有特性测量](https://developer.android.google.cn/jetpack/compose/layouts/intrinsic-measurements?hl=zh-cn)，以实现与 Rows 和 Columns 类似的效果。

> 链：考虑使用[排列方式](https://developer.android.google.cn/reference/kotlin/androidx/compose/foundation/layout/Arrangement?hl=zh-cn)不同的传统 Rows 和 Columns，以实现与 ConstraintLayout 中的链类似的效果



### `LazyColumn()`, `LazyRow()`: RcecyclerView



### ScrollView: Modifier.horizontalScroll / verticalScroll



### Pager(): ViewPager

**依赖**

> https://github.com/google/accompanist

**使用文档**

> https://developer.android.google.cn/jetpack/compose/layouts/pager?hl=en



### Modifier

**特点：**

1. 对顺序敏感
2. 多次调用会一次应用，而不是互相覆盖

**和函数参数的场景区别**

1. 通用属性用Modifier
2. 专用属性用函数参数

**常用的属性**

1. `padding() `: 增加边距；内/外取决于调用顺序
2. `background()`: 设置背景
3. `clip()`: 切边
4. `width()`, `height()`, `size()`: 设置尺寸
5. `clickable()`: 点击监听

**修饰符列表**

> https://developer.android.google.cn/jetpack/compose/modifiers-list?hl=zh-cn#Alignment



### 关于fragment

**官方迁移策略**

> 移除 fragment 和 Navigation 组件
>
> https://developer.android.google.cn/jetpack/compose/migrate/strategy?hl=zh-cn#removing-fragments

**相关资料**

1. Jetpack Compose 和即将退场的 Fragment

> https://blog.csdn.net/tq1086/article/details/119975661

2. Fragments with Jetpack compose

> https://zhuanlan.zhihu.com/p/523869335?utm_id=0



## 常用库

### 依赖库管理

> 只需指定 BoM 的版本，即可管理所有 Compose 依赖项
>
> https://developer.android.google.cn/jetpack/compose/bom

```kotlin
dependencies {
    // Import the Compose BOM
    implementation platform('androidx.compose:compose-bom:2023.05.01')

    // Override Material Design 3 library version with a pre-release version
    implementation 'androidx.compose.material3:material3:1.1.0-alpha01'

    // Import other Compose libraries without version numbers
    // ..
    implementation 'androidx.compose.foundation:foundation'
}
```



### lifecycle

> https://developer.android.google.cn/jetpack/androidx/releases/lifecycle?hl=zh-cn#declaring_dependencies



### 图片库

> https://coil-kt.github.io/coil/compose/

