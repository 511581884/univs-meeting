/*
postcss配置文件
将px转换成rem
*/
module.exports = {
  plugins: {
    "postcss-pxtorem": {
      //根元素的基准值
      rootValue: 37.5,
      //需要转换的CSS属性，*代表所有属性都转
      propList: ["*"]
    }
  }
};
