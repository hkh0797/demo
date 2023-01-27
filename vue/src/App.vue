<template class="paddingleft" >
  <Header />
  <Sidebar />
  <router-view/>
  <Footer />
</template>

<script>
import Header from '@/components/DemoHeader.vue'
import Footer from '@/components/DemoFooter.vue'
import Sidebar from '@/components/DemoSidebar.vue'

export default {
  name: 'App',
  components: {
    Header,
    Sidebar,
    Footer,
  },
  beforeMount () {
    document.body.style.paddingLeft = '290px'
  }
}
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

.paddingleft {
  padding-left: 290px;
}
</style>
