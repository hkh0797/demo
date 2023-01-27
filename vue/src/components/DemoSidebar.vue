<template>
    <sidebar-menu :menu="menu" @update:collapsed="onToggleCollapse" />
</template>

<script>
export default {
    data() {
        return {
            menu: [
                {
                    header: 'Main Navigation',
                    hiddenOnCollapse: true
                },
            ]
        }
    },
    methods: {
        fnPostList() {
            this.$axios.post(this.$serverUrl + "/nav/list", {
            }).then((res) => {

                const { data } = res.data.reduce((acc, curr) => {

                    if (acc.parentMap[curr.parentid]) {

                        (acc.parentMap[curr.parentid].child = acc.parentMap[curr.parentid].child || []).push(curr)

                    } else {

                        acc.data.push(curr)

                    }

                    acc.parentMap[curr.id] = curr

                    return acc

                }, { parentMap: {}, data: [] })

                data.forEach((item) => {
                    this.menu.push(item)
                })
            }).catch((err) => {
                if (err.message.indexOf('Network Error') > -1) {
                    alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
                }
            })
        },
        onToggleCollapse(collapsed) {
            if (collapsed == true) {
                document.body.style.paddingLeft = '65px'
            } else {
                document.body.style.paddingLeft = '290px'
            }
        }
    },
    mounted() {
        this.fnPostList()
    }
}
</script>