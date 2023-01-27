<template>
    <div>샘플입니다.</div>
    <div>
        <p>[[v-on:click]]</p>
        <p> {{ count }}회</p>
        <button v-on:click="countUp">카운터 업!</button>
        <button v-on:click="countDown">카운터 다운!</button>
    </div>
    <hr />
    <div>
        <p>[[substring]]</p>
        <p>계산 : {{ myPrice * 1.08 }}</p>
        <p>데이터 바인딩 : {{ "안녕하세요~ " + myName + "님" }}</p>
        <p>데이터 수정(substr => substring) : {{ myName.substring(0, 1) }}</p>
    </div>
    <hr />
    <div>
        <p>[[v-bind:src]]</p>
        <!-- 직접지정 -->
        <img src="@/assets/logo.png">
        <!-- v-bind로 지정 -->
        <img v-bind:src="fileName">
        <!-- v-bind:는 :로 생략가능하다. -->
        <!-- <img :src="fileName"> -->
        <a href="https://www.google.com/">링크를 직접지정</a>
        <p>
            <a v-bind:href="myURL">링크를 v-bind로 지정</a>
        </p>
    </div>
    <hr />
    <div>
        <p>[[v-bind:style, v-bind:align]]</p>
        <p :align="right">우측정렬 직접 지정</p>
        <p v-bind:align="myAlign">우측정렬을 v-bind 로 지정</p>

        <p style="color: #E80;">문자색 직접 지적</p>
        <p v-bind:style="{ color: myColor }">문자색을 v-bind로 지정</p>
        <hr>
        <p style="font-size: 200%">글자 크기 직접 지정</p>
        <p v-bind:style="{ fontSize: mySize }">글자크기를 v-bind로 지정</p>
        <hr>
        <p style="background-color: aqua;">배경색 직접 지정</p>
        <p v-bind:style="{ backgroundColor: myBackColor }">배경색을 v-bind로 지정</p>
    </div>
    <hr />
    <div>
        <p>[[v-model]]</p>
        <input v-model="myName" placeholder="이름">
        <p>나는 {{ myName }} 입니다.</p>

        <textarea v-model="myText"></textarea>
        <p>문장은,「{{ myText }}」</p>
        <p>문자수는 {{ myText.length }} 자입니다.</p>
    </div>
    <hr />
    <div>
        <p>[[checkbox]]</p>
        <label>
            <input type="checkbox" v-model="myCheck">체크박스의 상태는 {{ myCheck }}
        </label>
        <hr>
        <label>
            <input type="checkbox" value="red" v-model="myChecks">적
        </label>
        <br>
        <label>
            <input type="checkbox" value="green" v-model="myChecks">녹
        </label>
        <br>
        <label>
            <input type="checkbox" value="blue" v-model="myChecks">청
        </label>
        <br>
        선택한 색은 {{ myChecks }}
        <hr>
        <label>
            <input type="checkbox" v-model="myAgree">동의합니다.
        </label>
        <button v-bind:disabled="myAgree == false">송신</button>
        <hr>
        <label>
            <input type="radio" value="red" v-model="picked">적
        </label>
        <br>
        <label>
            <input type="radio" value="green" v-model="picked">녹
        </label>
        <br>
        <label>
            <input type="radio" value="blue" v-model="picked">청
        </label>
        <p> {{ picked }} 이 선택됨 </p>
    </div>
    <hr />
    <div>
        <p>[[select]]</p>
        <select v-model="myColor">
            <option disabled value="">색을 선택해 주세요</option>
            <option>red</option>
            <option>green</option>
            <option>blue</option>
            <option>orange</option>
            <option>brown</option>
        </select>
        <p v-bind:style="{ color: myColor }">선택한 색상은 {{ myColor }} 입니다. </p>
        <hr>
        <select v-model="myColor" multiple style="width:150px">
            <option>red</option>
            <option>green</option>
            <option>blue</option>
            <option>orange</option>
            <option>brown</option>
        </select>
        <p>선택한 색은 {{ myColor }} 입니다.</p>
    </div>
    <hr />
    <h2>[[간단한 계산기]]</h2>
    <div>
        <input v-model.number="num1">
        <input v-model.number="num2"> <br /><br />
        <button v-on:click="addcal">덧샘계산</button>
        <button v-on:click="subcal">뺄샘계산</button>
        <button v-on:click="multical">곱샘계산</button>
        <button v-on:click="divcal">나눗샘계산</button>
        <p>결과는 {{ result }} 입니다.</p>
    </div>
    <hr />
    <h2>[[[Shift] + [Enter] 키를 누르면 얼럿을 표시하는 예제]]</h2>
    <div>
        <input @keyup.shift.enter="showAlert" v-model="myText">
        <p>{{ myText }}</p>
    </div>
    <hr />
    <div>
        <ul>
            <li v-for="(item, index) in myArray" :key="index">{{ item }}
                <button v-on:click="modifyNumber(index)">++</button>
                <button v-on:click="deleteNumber(index)">삭제</button>
            </li>
            <br>
            <button v-on:click="addNumber()">추가</button>
            <button v-on:click="sortData()">정렬</button>
            <button v-on:click="showGuGu">구구단</button>
        </ul>
        <hr />
        <ul v-if="show">
            <li v-for="item in myArray" :key="item">
                <p v-for="item2 in 9" :key="item2">{{ item }}x{{ item2 }}={{ item * item2 }}</p>
            </li>
        </ul>
    </div>
    <hr />
    <div>
        <input v-model.number="price" type="number">원 x
        <input v-model.number="count" type="number">개
        <p> 합계 {{ sum }} 원</p>
        <p>세금포함 {{ taxIncluded }} 원</p>
    </div>
    <hr />
    <div>
        <p>감상은 140자 이내로 입력해 주세요.</p>
        <textarea v-model="myText"></textarea>
        <p v-bind:style="{ color: computedColor }">남은 글자는 {{ remaining }} 입니다.</p>
    </div>
    <hr />
    <div>
        <input v-model="findWord">
        <ul>
            <li v-for="item in findItems" :key="item">{{ item }}</li>
        </ul>
    </div>
    <hr />
    <div>
        <p v-bind:style="{ backgroundColor: mixColor }">{{ mixColor }}</p>
        <input type="range" v-model="R" min="0" max="255" /><br>
        <input type="range" v-model="G" min="0" max="255" /><br>
        <input type="range" v-model="B" min="0" max="255" /><br>
    </div>
    <hr />
    <div>
        <p>금지문자(복수입력 가능) <input :disabled="!isWritable" v-model="forbiddenText"></p>
        <p>제한시간을 입력하시오 <input :disabled="!isWritable" v-model="setTime">
            <button v-on:click="start">시작</button>
        </p>
        <p>남은시간{{ limitTime }}초</p>
        <p>문장:놔는 냐쁜아이오 그대는 비보인가... 세상이 모듀 나뿐 거라고 말해도 뱌보가 아니면 말 다했지!</p>
        <textarea :disabled="isWritable" v-model="inputText"></textarea>
        <p v-if="isResult">{{ wordCnt }}개의 문자를 입력하였습니다.</p>
        <p v-if="isResult">벌점: {{ resultScore }} (금지문자 1개당 12점)</p>
    </div>
    <hr />
    <h2>숫자가 빠르게 올라가는 애니메이션을 보여주며 값이 증가하는 input태그 예제</h2>
    <div>
        <p>값은 {{ animeNumber }}입니다.</p>
        <input v-model.number="myNumber" type="number">
    </div>
    <hr />
    <div>
        <p>chart (google 차트 플러그인)</p>
        <GChart :settings="{ packages: ['corechart', 'table', 'map'] }" type="ColumnChart" :data="chartData"
            :options="chartOptions" />
    </div>
    <hr />
    <div>
        <h2>Pinia (store 개념 플러그인)</h2>
        <!-- <h4>{{ counter.count }}</h4>
        <h4>Doubled {{ counter.doubleCount }}</h4>
        <button type="button" @click="counter.increment">increment</button> -->
    </div>
</template>

<script>
// import { useCounterStore } from '@/stores/counter';
export default {
    data() {
        return {
            count: 1,
            myPrice: 500,
            myName: '홍길동',
            fileName: require("@/assets/logo.png"),
            myURL: 'https://www.google.com/',
            myAlign: 'right',

            myColor: '',
            mySize: '200%',
            myBackColor: 'aqua',
            myText: '오늘 날씨 좋습니다.',
            myCheck: false,
            myChecks: [],
            myAgree: false,
            picked: 'red',
            num1: 0,
            num2: 0,
            result: 0,
            myArray: [2, 3, 4, 5, 6, 7, 8, 9],
            show: false,
            price: 100,
            findWord: '',
            items: ['설악산', '한라산', '북한산', '백두산', '지리산'],
            R: 255,
            G: 150,
            B: 100,
            forbiddenText: "나쁜,바보",
            setTime: 10,
            limitTime: 0,
            isWritable: true,
            isResult: false,
            inputText: "",
            forbiddenCnt: 0,
            myNumber: 0,
            tweenedNumber: 0,
            // Array will be automatically processed with visualization.arrayToDataTable function
            chartData: [
                ["Year", "Sales", "Expenses", "Profit"],
                ["2014", 1000, 400, 200],
                ["2015", 1170, 460, 250],
                ["2016", 660, 1120, 300],
                ["2017", 1030, 540, 350],
            ],
            chartOptions: {
                chart: {
                    title: "Company Performance",
                    subtitle: "Sales, Expenses, and Profit: 2014-2017",
                },
            },
        }
    },
    setup() {
        // const counter = useCounterStore();

        // return {
        //     counter,
        // }
    },
    methods: {
        countUp() {
            this.count++;
        },
        countDown() {
            this.count--;
        },
        addcal: function () {
            this.result = this.num1 + this.num2;
        },
        subcal: function () {
            this.result = this.num1 - this.num2;
        },
        multical: function () {
            this.result = this.num1 * this.num2;
        },
        divcal: function () {
            this.result = this.num1 / this.num2;
        },
        showAlert: function () {
            alert("Shift + Enter 를 눌렀습니다." + this.myText);
        },
        sortData: function () {
            this.myArray = this.myArray.filter(function (item, idx, array) {
                //조건에 맞는 것들만 찾아서 => 기존 배열로 변경
                //item:요소(값) / idx: 인덱스 / array 배열 : 필터의3인자 기능
                return array.indexOf(item) === idx;
                //배열의 아이템번호의 인덱스와 idx가 같은 것
                //해당 값의 인덱스 번호를 배열에서 찾아서 그것이 현재 배열의 인덱스와 같다면
                //다시말해 인덱스 맞는 것만 출력하겠다는 소리
            });
            this.myArray.sort(function (a, b) {
                return (a < b ? -1 : 1) //오름차순
            })
        },
        addNumber: function () {
            this.myArray.push(1);
        },
        modifyNumber: function (index) {
            this.myArray.splice(index, 1, this.myArray[index] + 1);
            //인덱스 위치에 있는 값을 +1 해준 값으로 변경
        },
        deleteNumber: function (index) {
            this.myArray.splice(index, 1);
            //인덱스 위치에 있는 값을 '' = 즉 없앰
        },
        showGuGu: function () {
            this.show = true;
        },
        //시작을 누르면 세팅이 이뤄진다.
        start: function () {
            this.isWritable = false;
            this.limitTime = this.setTime;
            this.timerObj = setInterval(() => { this.limitTime-- }, 1000);
            this.isResult = false;
        }
    },
    computed: {
        // price나 count가 변하면 합계 금액을 계산한다.
        sum: function () {
            return this.price * this.count;
        },
        // 합계 금액이 변하면 세금포함 금액을 계산한다.
        taxIncluded: function () {
            return this.sum * 1.08;
        },
        // myText의 길이가 변하면 남은 글자수를 계산한다.
        remaining: function () {
            return 140 - this.myText.length;
        },
        // remaining이 변하면 computedColor을 계산한다.
        computedColor: function () {
            var col = "green";
            if (this.remaining < 20) {
                col = "orange";
            }
            if (this.remaining < 1) {
                col = "red";
            }
            return col;
        },
        // this.findWord 가 변하면 그 문자가 포함된 리스트를 계산한다.
        findItems: function () {
            if (this.findWord) {
                return this.items.filter(function (value) {
                    return (value.indexOf(this.findWord) > -1);
                }, this);
            } else {
                // this.findWord 가 공백일땐 리스트를 그대로 반환한다.
                return this.items;
            }
        },
        // R,G,B의 값이 변하면 색을 계산한다.
        mixColor: function () {
            var ans = "RGB(" + this.R + "," + this.G + "," + this.B + ")";
            return ans;
        },
        resultScore: function () {
            return this.forbiddenCnt * 12;
        },
        // tweenedNumber 값이 변경되는 변화중 애니메이션을 산출한다.
        animeNumber: function () {
            return this.tweenedNumber.toFixed(0);
        }
    },
    watch: {
        //남은 초를 감시한다.
        limitTime: function () {
            //0초 이하가 되면 경고창 띄우고 타이머를 멈춤.
            if (this.limitTime <= 0) {
                alert("제한시간 입니다.");
                //인터벌 초기화
                clearInterval(this.timerObj);
                //기존 세팅 다시 돌려놓기
                this.isWritable = true;
                this.isResult = true;
                this.wordCnt = this.inputText.length;
            }
        },
        inputText: function () {
            var arrForbiddenText = this.forbiddenText.split(",");
            for (var i = 0; i < arrForbiddenText.length; i++) {
                var pos = this.inputText.indexOf(arrForbiddenText[i]);
                if (pos >= 0) {
                    alert(this.forbiddenText + "는 입력할 수 없습니다.");
                    //입력문제에서 금지 문자를 삭제한다.
                    this.inputText = this.inputText.substring(0, pos);
                    this.limitTime = this.limitTime + 10;
                    this.forbiddenCnt++;
                }
            }
        },
        // myNumber 를 감시하여 값이 변할경우 실행한다.
        myNumber: function () {
            // data의 tweenedNumber 프로퍼티를 1초에 myNumber까지 증가시킨다.
            this.$gsap.to(this.$data, 1, { tweenedNumber: this.myNumber })
        }
    },
}
</script>