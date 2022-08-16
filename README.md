# [DebouncedPlugin](https://github.com/sceneren/DebouncedPlugin)   [![](https://jitpack.io/v/sceneren/DebouncedPlugin.svg)](https://jitpack.io/private#sceneren/DebouncedRuntime)

# [DebouncedRuntime](https://github.com/sceneren/DebouncedRuntime)  [![](https://jitpack.io/v/sceneren/DebouncedRuntime.svg)](https://jitpack.io/private#sceneren/DebouncedRuntime)

## 功能列表

-基于ASM的 Android 点击事件防抖处理

# 开始

## 添加 jitpack.io

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

```

## 根目录build.grade 添加classpath

```

classpath "com.github.sceneren:DebouncedPlugin:$DebouncedPlugin_version"

```

## app的build.grade 添加plugin

```

apply plugin:'com.github.sceneren.debounced'

```

## 添加检查的辅助类，现在有2种方式来实现了

### 方式1

```
app的build.grade 添加依赖 默认延迟300ms

implementation 'com.github.sceneren:DebouncedRuntime:$DebouncedRuntime_version'
    
```

### 方式2

```
app的build.grade 添加配置

DebouncedExt{
    className = "自定义的类名"
    methodName = "自定义的函数名"
    //下面2个是可选的
    //checkViewOnClickAnnotation="自定义的注解的完整类名"
    //uncheckViewOnClickAnnotation="自定义的注解的完整类名"
}
    
```
### 上面的2种方式2选1，同时配置的话方式2，优先级高

# 用法

1、没有需要特殊处理的view可以直接使用,不需要任何操作

2、有需要可以连续点击的使用```@UncheckViewOnClick```标记，如果使用了自定义注解的方式请使用你自定义的注解

3、注意请参考 [TestClickUtils.kt](https://github.com/sceneren/DebouncedRuntime/blob/master/app/src/main/java/com/github/sceneren/debounced/TestClickUtils.kt) 、[CheckViewOnClick](https://github.com/sceneren/DebouncedRuntime/blob/master/debunced/src/main/java/com/github/sceneren/debounced/CheckViewOnClick.kt)  实现自定义注解和点解拦截的帮助类

## [Demo](https://github.com/sceneren/DebouncedRuntime)

## Thanks

[ASM_Transform](https://github.com/leavesCZY/ASM_Transform)
