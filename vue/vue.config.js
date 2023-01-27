// vue ui를 쓰지 않고 outputDir 설정하고 싶을 때 path 사용 (yarn add path)
// const path = require('path')
const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: 'D:\\DEV\\vue\\demo\\src\\main\\resources\\static'
  //  vue ui를 쓰지 않고 outputDir 설정하고 싶을 때 사용
  //  outputDir: path.resolve(__dirname, "../src/main/resources/static"),

  /*
    devServer: {
      proxy: {
        '/api': {
          // backend 통신 주소
          target: 'http://localhost:8090',
          // websoket을 프록시 하려는 경우
          ws: true,
          // true/false, Default: false - 호스트 헤더의 원본을 대상 URL로 변경합니다.
          changeOrgin: true
        }
      }
    }
   */
})