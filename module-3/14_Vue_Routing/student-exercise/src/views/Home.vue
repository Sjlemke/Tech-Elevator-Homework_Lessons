<!-- Router view for displaying the list of products on our main page -->
<template> <!-- contains the html for rthe page -->
    <div class='books'>  <!-- this the one and only div allowed in the template --> 
        <best-seller-list />   <!-- Vue component to list the products on the page -->
        <new-releases-list />
    </div>
    
</template>
<script> // contains the JavaScript for the page
 // The '@' is shorthand for the root folder for the app (/src)
 //                     /src/components/ProductsList would be OK too
import BestSellerList from '@/components/BestSellerList'
import NewReleasesList from '@/components/NewReleasesList'


export default {
components: {
    BestSellerList,
    NewReleasesList
    }
}
</script>

<style scoped></style>  