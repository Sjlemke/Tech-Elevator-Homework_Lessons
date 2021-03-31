<!-- Router view for displaying the list of products on our main page -->
<template> <!-- contains the html for rthe page -->
    <div class='my-books'>  <!-- this the one and only div allowed in the template --> 
        <reading-list />   <!-- Vue component to list the products on the page -->
        <div id="nav">
            <router-link to="/addBook">Add Book to Reading List</router-link>
        </div> 
    </div>
    
</template>
<script> // contains the JavaScript for the page
 // The '@' is shorthand for the root folder for the app (/src)
 //                     /src/components/ProductsList would be OK too
import ReadingList from '@/components/ReadingList'


export default {
components: {
    ReadingList
    }
}
</script>

<style scoped></style>  