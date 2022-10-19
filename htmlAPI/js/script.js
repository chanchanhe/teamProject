const dragAndDrog = document.querySelector(".dragAndDropArea"); 
const geolocation = document.querySelector(".geolocationArea");
const localStorage = document.querySelector(".localStorageArea");
let menuButton = document.querySelector(".menu-button");

menuButton.addEventListener('click', (event)=> {
  let menuList = event.target.closest('li');
  if(!menuList) return;

  let sibling = menuList.parentNode.children;

    for(let i = 0; i < sibling.length; i++){
      if(sibling[i] == menuList) {
        menuList.classList.add('seleted'); 
        localStorage.style.display = "none";
        geolocation.style.display = "none";
        dragAndDrog.style.display = "none";

         if (i === 0) {
          dragAndDrog.style.display = "block";
         } else if (i === 1) {
          geolocation.style.display = "block";
         } else if (i === 2) {
          localStorage.style.display = "block";
         }
 
      }
      else {
        sibling[i].classList.remove('seleted');
      }
    }
});
