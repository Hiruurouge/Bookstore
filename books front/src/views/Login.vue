<template>
     <div class="container">
        <h1>Book Management System</h1>
        <hr>
        <h2>Log in</h2>

        <form  @click="prevent" id="myform">

            <!-- Add hidden form field to handle update -->
            <input name="mail" placeholder="mail" type="text"  class="form-control mb-4 col-4">
            <input name="password" placeholder="password" type="password" class="form-control mb-4 col-4">
            <button type="button" @click="submitForm()" class="btn btn-info col-2"> Log In</button>
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
            user:""
        }
    },

   async beforeMount() {
    try {
      await axios
      .get('http://localhost:8080/user')
      .then((response) => (this.user = response.data)) /* Fetching data from Spring Boot */
      console.log(this.user)
    } catch (err) {
          console.error(err)
    }
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
            let jsonRes = {mail: "", password: ""};
            jsonRes=JSON.parse(JSON.stringify(jsonRes))
            jsonRes.mail = results[0].value;
            jsonRes.password = results[1].value;
            console.log(jsonRes)
            var use=JSON.parse(JSON.stringify(this.user))
            console.log(use)
            var redirect={mail: "", password: "",id:""}
          for (let i = 0; i < use.length; i++) {
            if(use[i].mail==jsonRes.mail && use[i].password==jsonRes.password)
            {
              redirect=use[i];
            }
            else{

              //this.$router.push("Register")
              console.log("existe pas")
            }
          }
          console.log(redirect)
          if(redirect.mail=="") 
          {
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Account does not exist!',
              footer: '<a href="http://localhost:8081/register">Wanna create an account?</a>'
            })
          }
          else if(redirect.mail=="admin@admin.com")
          {
            localStorage.user=redirect.id
            this.$router.push("Admin")
          }

          else if(redirect.mail!="admin@admin.com")
          {
            localStorage.user=redirect.id            
            this.$router.push("Books")
          }


          
        }
        
   }

}
</script>