<template>
    <div class = "container">
            <h1 class = "text-center"> Book List</h1>

            <div class="cont">
                <div class="add">
                <a   @click="updateBook($event)" class="btn btn-success">  Add  </a>
                </div>
                <div class="add">
                            <a   href="http://localhost:8081/books" class="btn btn-success">  See all books </a>
                </div>
            </div>

            <span> </span>
            <table class = "table table-striped">
                <thead>
                    <tr>
                        <th> Book id</th>
                        <th> Book  Name</th>
                        <th> Book Author</th>
                        <th> Book Publisher</th>
                        <th> Book ISBN</th>
                        <th>Published on</th>
                    </tr>

                </thead>
                <tbody>
                    <tr v-for="book in books" v-bind:key="book" >
                        <td> {{book.id }}</td>
                        <td> {{book.name }}</td>
                        <td> {{book.author}}</td>    
                        <td> {{book.Publisher}}</td>
                        <td> {{book.isbn}}</td>
                        <td> {{book.date}}</td>
                        <td>
                    
                        <a v-bind:id="book.id"  @click="updateBook($event)" class="btn btn-primary">Update</a>
                        <a v-bind:id="book.id" @click="deleteBook($event)" class="btn btn-danger">Delete</a>
                    </td>
                    </tr>
                </tbody>
            </table>
        </div>
</template>
<style scoped>
.add{
    margin-bottom: 50px;
    justify-content: space-around;
}
</style>
<script>
import axios from 'axios'
export default {
    data() {
        return {
            books:"",
            resp:""
        }
    },
    async mounted() {
try {
      await axios
      .get('http://localhost:8080/books')
      .then((response) => (this.books = response.data)) /* Fetching data from Spring Boot */
        console.log(this.books)

    } catch (err) {
          console.error(err)
    }
    
    },
    methods:{
    updateBook(event)
    {
      const id = event.currentTarget.id;
      localStorage.id=id;
      const url = " http://localhost:8081/update/" ;
      console.log(url)
      window.location.href = url;
    },
    async deleteBook(event) {
      const id = event.currentTarget.id;
      const url = " http://localhost:8080/deleteBook/" + id;
      console.log(url)
      //window.location.href = url;
      try {
      await axios
      .get(url)
      .then((response) => (this.resp = response.data)) /* Fetching data from Spring Boot */
        console.log(this.resp)

    } catch (err) {
          console.error(err)
    }
    this.$router.go()
    }
  }
}
</script>
