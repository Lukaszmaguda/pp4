getProducts= () => {
    return fetch("/api/products")
        .then(response => response.json());
}

getCurrentOffer = () => {
    return fetch("/api/current-offer")
        .then(response => response.json());
}

createProductHtmlEl = (productData) =>{
    const template =`
        <div>
        <img src = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fimgur.com%2Ft%2Fcorgi&psig=AOvVaw2WSpyehouSumrZ-LKxr-f3&ust=1714461408218000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPjjxuvw5oUDFQAAAAAdAAAAABAE" width =200 height =200/>
        <h4> ${productData.name}</h4>
        <span>${productData.description}</span>
        <span>${productData.price}</span>
        <button data-id="${productData.id"}> Add to cart </button>}
        </div>
        `;
    const newEl = document.createElement("li");
    newEl.innerHTML = template.trim();
    return newEl;
}

document.addEventListener("DOMContentLoaded", () => {
    console.log("it works")
    const productsList = document.querySelector("#productList");
    getProducts()
        .then(products => products.map(createProductHtmlEl))
        .then(productsHtmls => {
            productsHtmls.forEach(htmlEl => productList.appendChild(htmlEl))
            })
});