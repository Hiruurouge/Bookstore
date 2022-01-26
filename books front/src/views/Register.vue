<template>
     <div class="container">
        <h1>Book Management System</h1>
        <hr>
        <h2>Register</h2>

        <form  @click="prevent" id="myform">

            <!-- Add hidden form field to handle update -->

            <input type="hidden" placeholder="id"  value="1"  class="form-control mb-4 col-4">
            <input type="text" name="first_name" placeholder="first name"   class="form-control mb-4 col-4">
            <input name="last_name" placeholder="last name" type="text"    class="form-control mb-4 col-4">
            <input name="mail" placeholder="isbn" type="text"  class="form-control mb-4 col-4">
            <input name="password" placeholder="password" class="form-control mb-4 col-4">
            <button type="button" @click="submitForm()" class="btn btn-info col-2"> Register</button>
        </form>

        <hr>

        <a th:href="@{/}"> Back to Book List</a>
    </div>
</template>
<script>
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
            let jsonRes = {last_name: "", mail: "", first_name: "", password: ""};
           // jsonRes.id = results[0].value;
            jsonRes.first_name = results[1].value;
            jsonRes.last_name = results[2].value;
            jsonRes.mail = results[3].value;
            jsonRes.password = results[4].value;
            console.log(jsonRes)
           // console.log(config);
            await axios.post('http://localhost:8080/saveUser',jsonRes);
            alert("Nice");
            this.$router.push("LOgin")
        }
        
   }

}
</script>