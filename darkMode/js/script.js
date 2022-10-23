const container = document.querySelector('.container');
const toggleBtn = document.querySelector('#toggle-btn');
let  mode = localStorage.getItem('mode');

if( mode ) { /* 페이지 접속시 모드가 다크이면 container에 다크 클래스 추가 */
  container.classList[mode === 'dark' ? 'add' : 'remove']('dark');
}


toggleBtn.addEventListener("click", ()=> { /* toggleBtn 클릭시에 */
  if( (container.classList.contains('dark')) ) {  /* container가 다크 클래스를 포함하고 있으면 */
    container.classList.remove('dark'); /* 다크 클래스를 삭제 한다. 그러면 root 의사 클래스로 지정해놨던 css 값으로 적용 되어서 light 모드가 된다. */
    localStorage.setItem('mode', 'light'); /* 로컬 스토리지에 모드 키로 mode를 값을 light로 저장한다.*/
  } else { /* container가 다크 클래스를 포함하고 있지 않으면 */
    container.classList.add('dark'); /* container에 다크 클래스를 추가한다. */
    localStorage.setItem('mode', 'dark'); /* 로컬 스토리지에 모드를 dark로 저장한다. */
  }
});