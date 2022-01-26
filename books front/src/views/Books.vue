<template>
<div id="app">
  <div class="search-wrapper">
  <h1>Our Catalog</h1>
  </div>
  <div class="wrapper">
    <div @click="addReadingList($event)"  class="card" v-for="post in filteredList" v-bind:key="post" v-bind:id="post.id">
        <img v-bind:src="post.image"/>
        <small>posted by: {{ post.author }}</small>
        {{ post.name }}
    </div>
  </div>
</div>
</template>

    
<style lang="scss" scoped>
@import 'Books.scss';
</style>

<script>

import axios from 'axios'
export default {
data() {
    return {
        postList:"",
        search:"",
        filteredList:"",
        book:""

    }
  },

  async mounted() {
      try {
      await axios
      .get('http://localhost:8080/books')
      .then((response) => (this.filteredList = response.data)) /* Fetching data from Spring Boot */
        console.log(this.filteredList)

    } catch (err) {
          console.error(err)
    }

  },
  methods: {
         getJsonElement(data,id) {
        return data.filter(
      function(data){ return data.id == id }


    );
  },
    addReadingList(event){
      localStorage.book=event.currentTarget.id;
      let id=event.currentTarget.id
      let test=JSON.parse(JSON.stringify(this.filteredList))
      this.book=this.getJsonElement(test,id)[0]
      console.log(this.book)
    }
  }
 }

</script>