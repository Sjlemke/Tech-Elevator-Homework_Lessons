import Vue from 'vue'  //Access the code to support vue
import App from './App.vue'  //Access the code for our main page
import store from './store'  //Access the code to support the vue data store
import router from './router' //access the code to support Vue router

Vue.config.productionTip = false

new Vue({    //
  store,    //tell vue we are using the vue data store
  router,   //tell vue we are using vue router
  render: h => h(App) //tell vue our main page is App.vye component
}).$mount('#app')  //tell vue to add whatever it generates to the index.html element with id='app'
