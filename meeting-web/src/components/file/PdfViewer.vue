<template>
  <pdf v-for="i in numPages" :key="i" :page="i" :src="loadingTask" />
</template>

<script>
import pdf from "vue3-pdf";
import { ref } from "vue";
import CMapReaderFactory from 'vue3-pdf/src/CMapReaderFactory.js'

export default {
  name: "PdfViewer",
  components: { pdf },
  props: ["url"],
  setup() {
    // eslint-disable-next-line vue/no-setup-props-destructure
    // const url = props.url;
    // 因为有跨域问题，先使用本地文件进行测试
    const url = "test.pdf"
    const numPages = ref(0);
    const loadingTask = pdf.createLoadingTask({
      url,
      // 解决中文乱码和印章错误等问题
      cMapUrl: "https://cdn.jsdelivr.net/npm/pdfjs-dist@2.5.207/cmaps/",
      cMapPacked: true,
      CMapReaderFactory
    });
    loadingTask.promise
      .then((pdf) => {
        numPages.value = pdf.numPages;
      })
      .catch((err) => {
        console.error("pdf 加载失败", err);
      });
    return {
      numPages,
      loadingTask,
    };
    
  },
};
</script>
<style scoped>

#viewer{
  height: 100%;
}
</style>
