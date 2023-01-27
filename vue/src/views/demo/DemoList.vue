<template>
    <hr />
    <div>
        <div>
            <button type="button" v-on:click="fnWrite">리스트 등록</button>
        </div>
    </div>
    <hr />
    <div>
        <div>
            <input v-model="filterText" placeholder="검색" />
        </div>
    </div>
    <hr />
    <table>
        <thead>
            <tr>
                <th>No (숫자)</th>
                <th>제목 (문자)</th>
                <th>작성자</th>
                <th>등록일시 (날짜)</th>
            </tr>
        </thead>
        <tbody id>
            <tr v-for="(row, idx) in filteredList" :key="idx">
                <td>{{ row.idx }}</td>
                <td><a v-on:click="fnView(`${row.idx}`)">{{ row.title }}</a></td>
                <td>{{ row.author }}</td>
                <td>{{ row.createdAt }}</td>
            </tr>
        </tbody>
    </table>
    <hr />
    <!-- <div v-if="paging.total_list_cnt > 0"> Oracle DB일 경우 -->
    <div v-if="paging.totalListCnt > 0">
        <span class="pg">
            <a href="javascript:;" @click="fnPage(1)">&lt;&lt;</a>
            <a href="javascript:;" v-if="paging.startPage > 10" @click="fnPage(`${paging.startPage - 1}`)">&lt;</a>
            <template v-for=" (n, index) in paginavigation()">
                <template v-if="paging.page == n">
                    <strong :key="index">{{ n }}</strong>
                </template>
                <template v-else>
                    <a href="javascript:;" @click="fnPage(`${n}`)" :key="index">{{ n }}</a>
                </template>
            </template>
            <a href="javascript:;" v-if="paging.totalPageCnt > paging.endPage"
                @click="fnPage(`${paging.endPage + 1}`)">&gt;</a>
            <a href="javascript:;" @click="fnPage(`${paging.totalPageCnt}`)">&gt;&gt;</a>
        </span>
    </div>
</template>

<script>
import { ref } from 'vue'

export default {
    data() {
        return {
            requestBody: {}, //리스트 페이지 데이터전송
            list: {}, //리스트 데이터
            searchList: [],
            no: '', //게시판 숫자처리
            paging: {
                block: 0,
                endPage: 0,
                nextBlock: 0,
                page: 0,
                pageSize: 0,
                prevBlock: 0,
                startIndex: 0,
                startPage: 0,
                totalBlockCnt: 0,
                totalListCnt: 0,
                totalPageCnt: 0,
            }, //페이징 데이터
            page: this.$route.query.page ? this.$route.query.page : 1,
            size: this.$route.query.size ? this.$route.query.size : 10,
            keyword: this.$route.query.keyword,
            paginavigation: function () { //페이징 처리 for문 커스텀
                let pageNumber = [] //;
                let startPage = this.paging.startPage;
                let endPage = this.paging.endPage;
                for (let i = startPage; i <= endPage; i++) pageNumber.push(i);
                return pageNumber;
            }
        }
    },
    setup() {
		const filterText = ref('')

        return {
            filterText,
        }
    },
	computed: {
		filteredList() {
			let filter = this.filterText
			if (!filter.length) return this.list
			return this.list.filter( row => 
                row.title.toLowerCase().includes(filter.toLowerCase())
			)
		}
	},
    mounted() {
        this.fnGetList()
    },
    methods: {
        fnGetList() {
            this.requestBody = { // 데이터 전송
                keyword: this.keyword,
                page: this.page,
                size: this.size
            }

            this.$axios.get(this.$serverUrl + "/demo/list", {
                params: this.requestBody,
                headers: {}
            }).then((res) => {
                // this.list = res.data  //서버에서 데이터를 목록으로 보내므로 바로 할당하여 사용할 수 있다.

                if (res.data.resultCode === "OK") {
                    this.list = res.data.data
                    this.paging = res.data.pagination
                    this.no = this.paging.totalListCnt - ((this.paging.page - 1) * this.paging.pageSize)
                }
            }).catch((err) => {
                if (err.message.indexOf('Network Error') > -1) {
                    alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
                }
            })
        },
        fnPostList() {
            this.$axios.post(this.$serverUrl + "/demo/list", {
                params: this.requestBody,
                headers: {}
            }).then((res) => {
                this.list = res.data
            }).catch((err) => {
                if (err.message.indexOf('Network Error') > -1) {
                    alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
                }
            })
        },
        fnView(idx) {
            this.requestBody.idx = idx
            this.$router.push({
                path: './detail',
                query: this.requestBody
            })
        },
        fnWrite() {
            this.$router.push({
                path: './write'
            })
        },
        fnPage(n) {
            if (this.page !== n) {
                this.page = n
                this.fnGetList()
            }
        },
    },
}
</script>