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
        <img src = "https://i.pinimg.com/736x/05/fe/65/05fe657712b74bafc141f60577ac68a2.jpg" width =200 height =200/>
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