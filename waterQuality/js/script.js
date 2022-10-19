import water from "./hangang.js";

let table = document.querySelector("table");
let select = document.querySelector("select");

let des  =  Object.values(water.DESCRIPTION);     
let info = Object.keys(water.DESCRIPTION).map(value => value.toLowerCase());

window.onload = () => {
  let site = [];

  for(let index in water.DATA) {
      site.push(water.DATA[index]['site_id']);
  }
   
   let siteSet = new Set([...site]);

   for(let siteName of siteSet) {
       let option = document.createElement("option");
       option.value = siteName;
       option.innerText = siteName;
       select.append(option);
   }
   tableDisplay(site[0]);
}

select.addEventListener('change', (e)=> {
    tableDisplay(e.target.value)
})

function tableDisplay(selectOptionSite) {
  table.replaceChildren();

  let tr = document.createElement("tr");

  des.forEach((value)=> {
    let th = document.createElement("th");

    th.innerHTML = value;
    tr.appendChild(th);
    table.appendChild(tr);
  })

  for(let index in water.DATA) {
    let tr2 = document.createElement("tr");
    table.appendChild(tr2);

    for(let value of info) {
      let td = document.createElement("td");
      if(water.DATA[index]['site_id'] === selectOptionSite) {
        let waterValue = document.createTextNode(water.DATA[index][value]);

        td.appendChild(waterValue);
        tr2.appendChild(td); 
      }
    }
  }
}