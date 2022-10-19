const container = document.querySelector('.container');
const toggleBtn = document.querySelector('#toggle-btn');
let  mode = localStorage.getItem('mode');

if( mode ) {
  container.classList[mode === 'dark' ? 'add' : 'remove']('dark');
}

toggleBtn.addEventListener("click", ()=> {
  if( (container.classList.contains('dark')) ) {
    container.classList.remove('dark');
    localStorage.setItem('mode', 'light');
  } else {
    container.classList.add('dark');
    localStorage.setItem('mode', 'dark');
  }
});