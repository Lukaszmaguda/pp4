async function log Products(){
      const response = await fetch("/api/products");
      const movies = await response.json();
      console.log(products);
    }


}