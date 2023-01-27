<template>
    <div>
        <h1>Tree Example</h1>
    </div>
    <hr />
    <!-- <input v-model="searchText" type="text" /> -->

    <p>
        <label for="showCheckBoxes">Checkboxes</label>
        <input id="showCheckBoxes" type="checkbox" v-model="config.checkboxes" />

        <label for="padding"> | Padding</label>
        <input id="padding" type="number" v-model.number="config.padding" />

        <label for="editable"> | Editable</label>
        <input id="editable" type="checkbox" v-model="config.editable" />

        <label for="disabled"> | Disabled</label>
        <input id="disabled" type="checkbox" v-model="config.disabled" />

        <label for="keyboardNavigation"> | Keyboard Navigation</label>
        <input id="keyboardNavigation" type="checkbox" v-model="config.keyboardNavigation" />

        <label for="DragandDrop"> | DragandDrop</label>
        <input id="DragandDrop" type="checkbox" v-model="config.dragAndDrop" />

        <label for="checkMode"> | Checkmode auto</label>
        <input id="checkMode" type="checkbox" :value="modeBool" @input="changeMode" />
    </p>
    <hr />
    <tree
        :config="config"
        :nodes="nodes"
        @nodeFocus="log($event)"
    />
    <hr />

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>PARENT ID</th>
                <th>LABEL</th>
                <th>ORDER SEQ</th>
                <th>TREE DEPTH</th>
                <th>TEXT</th>
                <th>CHILDREN</th>
            </tr>
        </thead>
        <tbody id>
            <tr v-for="(row, id) in nodes" :key="id">
                <td>{{ row.id }}</td>
                <td>{{ row.parentid }}</td>
                <td>{{ row.label }}</td>
                <td>{{ row.orderseq }}</td>
                <td>{{ row.treedepth }}</td>
                <td>{{ row.text }}</td>
                <td>{{ row.children }}</td>
            </tr>
        </tbody>
    </table>
</template>

<script>
// import { ref } from 'vue';
import treeview from "vue3-treeview";
import "vue3-treeview/dist/style.css";

export default {
    data: () => {
        return {
            modeBool: false,
            nodes: {},
            config: {
                roots: ['0'],
                keyboardNavigation: false,
                dragAndDrop: false,
                checkboxes: false,
                editable: false,
                disabled: false,
                padding: 25,
            },
        };
    },
    components: {
        tree: treeview,
    },
    methods: {
        fnPostList() {
            this.$axios.post(this.$serverUrl + "/tree/list", {
            }).then((res) => {
                this.nodes = res.data;
            }).catch((err) => {
                if (err.message.indexOf('Network Error') > -1) {
                    alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
                }
            })
        },
        changeMode() {
            this.modeBool = !this.modeBool;
            this.config.checkMode = this.modeBool ? 0 : 1;
        },
        log(e) {
            // console.log(e)
            this.$emit("nodeFocus", e)
        },
    },
    mounted() {
        this.fnPostList()
    }
}
</script>