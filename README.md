# DebouncedPlugin   [![](https://jitpack.io/v/sceneren/DebouncedPlugin.svg)](https://jitpack.io/private#sceneren/DebouncedRuntime)
# DebouncedRuntime  [![](https://jitpack.io/v/sceneren/DebouncedRuntime.svg)](https://jitpack.io/private#sceneren/DebouncedRuntime)



## 功能列表

-基于ASM Transform Android 点击事件防抖处理
-Grade 8.0 后会移除 Transform

# 开始

------

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

apply plugin: 'Debounced'

```
## app的build.grade 添加依赖
```
    
implementation 'com.github.sceneren:DebouncedRuntime:$DebouncedRuntime_version'
    
```

## Thanks

[ASM_Transform](https://github.com/leavesCZY/ASM_Transform)