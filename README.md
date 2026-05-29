# cordova-plugin-walle-channel

Cordova 插件：在 Android 运行时从 APK 的 V2 签名块读取 [Walle](https://github.com/Meituan-Dianping/walle) 注入的渠道号。

配合「母包构建一次 → 加固 → 签名 → `walle batch` 批量注入渠道」的发布流水线使用，避免每个渠道都全量重新打包。

## 安装

```bash
cordova plugin add https://github.com/lixunlv/cordova-plugin-walle-channel.git
```

仅 Android 平台有原生实现。

## 使用

```js
cordova.plugins.walleChannel.getChannel(
  function (channel) {
    // 注入包返回渠道名（如 'huawei'）；未注入时返回空串
    console.log('dist channel:', channel);
  },
  function (err) {
    console.log('getChannel fail:', err);
  }
);
```

## 实现说明

- 原生侧调用 `com.meituan.android.walle.WalleChannelReader.getChannel(context)`。
- 依赖的 `library-1.1.6.aar` 为 Walle 官方读取库（Apache 2.0），随插件附带（jcenter 已关停、Maven Central 无官方包，故内置 aar）。
- cordova 默认 `fileTree(dir:'libs', include:'*.jar')` 不收 aar，故通过 `src/android/walle.gradle`（`flatDir` + `implementation(name:'library-1.1.6', ext:'aar')`）显式引入。

## License

MIT（插件代码）；内置 aar 遵循 Apache 2.0。
