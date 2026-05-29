var exec = require('cordova/exec');

module.exports = {
  // 从 APK V2 签名块读取 Walle 注入的渠道；未注入时回调空串
  getChannel: function (success, error) {
    exec(success, error, 'WalleChannel', 'getChannel', []);
  },
};
