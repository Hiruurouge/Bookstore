<template>
     <div class="container">
        <h1>Book Management System</h1>
        <hr>
        <h2>Update Book</h2>

        <form  @click="prevent" id="myform">

            <!-- Add hidden form field to handle update -->



            <input type="text" placeholder="id"  name="id" v-bind:value="book.id"  class="form-control mb-4 col-4">
            <input name="name"  placeholder="name" v-bind:value="book.name"  class="form-control mb-4 col-4">
            <input name="author" placeholder="author" type="text"  v-bind:value="book.author"  class="form-control mb-4 col-4">
            <input name="isbn" placeholder="isbn" type="text"  v-bind:value="book.isbn"  class="form-control mb-4 col-4">
            <input name="publisher" placeholder="publisher" type="text" v-bind:value="book.publisher"  class="form-control mb-4 col-4">
            <input type="text" placeholder="date" name="date" v-bind:value="book.date"  class="form-control mb-4 col-4">
            <input type="text"  placeholder="image" name="image" v-bind:value="book.image"  class="form-control mb-4 col-4">


            <button type="button" @click="submitForm()" class="btn btn-info col-2"> Update Book</button>
        </form>

        <hr>

        <a th:href="@{/}"> Back to Book List</a>
    </div>
</template>
<script>
import Swal from 'sweetalert2'
import axios from 'axios'
export default {
    data() {
        return {
            id:"",
            books:"",
            book:"",
            form: {
                name: '',
                isbn: '',
                id: '',
                author: '',
                date:'',
                message: '',
                image: ''
            }
        }
    },

   async beforeMount() {
    console.log("ici")
    this.id=localStorage.id
    console.log(this.id)   
    try {
      await axios
      .get('http://localhost:8080/books')
      .then((response) => (this.books = response.data)) /* Fetching data from Spring Boot */

    } catch (err) {
          console.error(err)
    }
        let test=JSON.parse(JSON.stringify(this.books))
        this.book=this.getJsonElement(test,this.id)[0]
        console.log(this.book.id)
        },
   methods:
   {
     getJsonElement(data,id) {
        return data.filter(
      function(data){ return data.id == id }
    );
    },
      async  submitForm(){
            var results=document.getElementById("myform").elements 
            let jsonRes = {author: "", date: "", image: "", isbn: "", name: "", publisher: ""};
           // jsonRes.id = results[0].value;
            jsonRes.name = results[1].value;
            jsonRes.author = results[2].value;
            jsonRes.isbn = results[3].value;
            jsonRes.publisher = results[4].value;
            jsonRes.date = results[5].value;
            jsonRes.image = results[6].value;
            console.log(jsonRes.isbn)
           // console.log(config);
                await axios.post('http://localhost:8080/saveBook',jsonRes);
               await Swal.fire(
                    'Nice!',
                    'Book has been updated!',
                    'success'
                )
            window.location.href="http://localhost:8081/Admin"
        }
        
   }

}
</script>