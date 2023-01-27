<template>
  <div>
    <hr />
    <div>
      <button type="button" v-on:click="fnUpdate">수정</button>&nbsp;
      <button type="button" v-on:click="fnDelete">삭제</button>&nbsp;
      <button type="button" v-on:click="fnList">목록</button>
    </div>
    <hr />
    <div>
      <h3>{{ title }}</h3>
      <hr />
      <div>
        <strong>{{ author }}</strong>
        <hr />
        <span>{{ createdAt }}</span>
      </div>
    </div>
    <hr />
    <div>
      <span>{{ contents }}</span>
    </div>
    <hr />
    <div>
      <button type="button" v-on:click="fnUpdate">수정</button>&nbsp;
      <button type="button" v-on:click="fnDelete">삭제</button>&nbsp;
      <button type="button" v-on:click="fnList">목록</button>
    </div>
  </div>
</template>
  
<script>
export default {
  data() { //변수생성
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      title: '',
      author: '',
      contents: '',
      createdAt: ''
    }
  },
  mounted() {
    this.fnGetView()
  },
  methods: {
    fnGetView() {
      this.$axios.get(this.$serverUrl + '/demo/' + this.idx, {
        params: this.requestBody
      }).then((res) => {
        this.title = res.data.title
        this.author = res.data.author
        this.contents = res.data.contents
        this.createdAt = res.data.createdAt
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    fnList() {
      delete this.requestBody.idx
      this.$router.push({
        path: './list',
        query: this.requestBody
      })
    },
    fnUpdate() {
      this.$router.push({
        path: './write',
        query: this.requestBody
      })
    },
    fnDelete() {
      if (!confirm("삭제하시겠습니까?")) return

      this.$axios.delete(this.$serverUrl + '/demo/' + this.idx, {})
        .then(() => {
          alert('삭제되었습니다.')
          this.fnList();
        }).catch((err) => {
          console.log(err);
        })
    }
  }
}
</script>
<style scoped>

</style>