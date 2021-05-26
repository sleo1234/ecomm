/**
 * 
 */
//var jsonProd=decodeHtml(products);


function filterProductByPrice(priceValue){
var res = jsonProd.filter(function(o) {
  // check value is within the range
  
  return o.price <= priceValue;
});
return res

}