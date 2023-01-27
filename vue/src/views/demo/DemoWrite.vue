<template>
    <div>
      <hr />
      <div>
        <button type="button" v-on:click="fnSave">저장</button>&nbsp;
        <button type="button" v-on:click="fnList">목록</button>
      </div>
      <hr />
      <div>
        <input type="text" v-model="title" placeholder="제목을 입력해주세요.">
      </div>
      <hr />
      <div>
        <input type="text" v-model="author" placeholder="작성자를 입력해주세요." v-if="idx === undefined">
      </div>
      <hr />
      <div>
        <textarea id="" cols="30" rows="10" v-model="contents" style="resize: none;">
        </textarea>
      </div>
      <div>
        <button type="button" v-on:click="fnSave">저장</button>&nbsp;
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
        created_at: ''
      }
    },
    mounted() {
      this.fnGetView()
    },
    methods: {
      fnGetView() {
        if (this.idx !== undefined) {
          this.$axios.get(this.$serverUrl + '/demo/' + this.idx, {
            params: this.requestBody
          }).then((res) => {
            this.title = res.data.title
            this.author = res.data.author
            this.contents = res.data.contents
            this.created_at = res.data.created_at
          }).catch((err) => {
            console.log(err)
          })
        }
      },
      fnList() {
        delete this.requestBody.idx
        this.$router.push({
          path: './list',
          query: this.requestBody
        })
      },
      fnView(idx) {
        this.requestBody.idx = idx
        this.$router.push({
          path: './detail',
          query: this.requestBody
        })
      },
      fnSave() {
        let apiUrl = this.$serverUrl + '/demo'
        this.form = {
          "idx": this.idx,
          "title": this.title,
          "contents": this.contents,
          "author": this.author
        }
  
        if (this.idx === undefined) {
          //INSERT
          this.$axios.post(apiUrl, this.form)
          .then((res) => {
            alert('글이 저장되었습니다.')
            this.fnView(res.data.idx)
          }).catch((err) => {
            if (err.message.indexOf('Network Error') > -1) {
              alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
            }
          })
        } else {
          //UPDATE
          this.$axios.patch(apiUrl, this.form)
          .then((res) => {
            alert('글이 저장되었습니다.')
            this.fnView(res.data.idx)
          }).catch((err) => {
            if (err.message.indexOf('Network Error') > -1) {
              alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
            }
          })
        }
      }
    }
  }
  </script>
  <style scoped>
  
  </style>