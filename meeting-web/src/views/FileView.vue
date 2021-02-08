<template>
  <View navBar navBarTitle="会议文件">
    <office-viewer v-if="file.extension!=='pdf'" :url="file.url"/>
    <pdf-viewer v-else :url="file.url"/>
  </View>
</template>

<script>
import View from "@/components/common/View.vue"
import OfficeViewer from "@/components/file/OfficeViewer.vue"
import PdfViewer from "@/components/file/PdfViewer.vue"
const file={
  extension: 'pdf1',
  url: encodeURIComponent('https://gitee.com/lyj578/test11111/raw/master/test.docx')
  //url: 'https://dakaname.oss-cn-hangzhou.aliyuncs.com/file/2018-12-28/1546003237411.pdf'
}
export default {
  name: 'FileView',
  components:{ OfficeViewer, PdfViewer, View},
  setup() {
    return {
      file
    }
  }
}
</script>
