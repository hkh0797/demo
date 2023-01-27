<template>
    <header>
        <div id="nav">
            <router-link to="/">Home</router-link> |
            <router-link to="/demo/list">게시판</router-link> |
            <router-link to="/tree">트리</router-link> |
            <!-- <router-link to="/poketmon">포켓몬 게시판</router-link> | -->
            <router-link to="/sample">샘플</router-link> |
        </div>
    </header>
</template>
<script>
export default {
    name: 'demo_header',
}
</script>
<style>

</style>