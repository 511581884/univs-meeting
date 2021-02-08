<template>
  <!--微软在线office文件预览：缺点：加载的时候可能会慢，且较不适合移动端-->
  <!--
  <iframe
    :src="`https://view.officeapps.live.com/op/embed.aspx?src=${url}`"
    id="viewer"
    frameborder="0" 
  ></iframe>
  -->
  <!--xdoc在线office文件预览，速度较快-->
  <iframe :src="`http://view.xdocin.com/xdoc?_xdoc=${url}`" id="viewer"  frameborder="0"/>
</template>

<script>
export default {
  name: "OfficeViewer",
  props: ["url"],
};
</script>

<style scoped>
#viewer {
  height: 95vh;
  width: 100vw;
}
</style>
