import water from "./hangang.js";

let table = document.querySelector("table");
let select = document.querySelector("select");

let des = [water.DESCRIPTION.MSR_DATE
          ,water.DESCRIPTION.MSR_TIME
          ,water.DESCRIPTION.SITE_ID
          ,water.DESCRIPTION.W_CN
          ,water.DESCRIPTION.W_DO
          ,water.DESCRIPTION.W_PH
          ,water.DESCRIPTION.W_PHEN
          ,water.DESCRIPTION.W_TEMP
          ,water.DESCRIPTION.W_TN
          ,water.DESCRIPTION.W_TOC
          ,water.DESCRIPTION.W_TP];

let info = [  'msr_date',
              'msr_time',
              'site_id', 
              'w_cn',
              'w_do',
              'w_ph',
              'w_phen',
              'w_temp',
              'w_tn',
              'w_toc',
              'w_tp'
            ];

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

  for(let i = 0; i < des.length; i++) {
    let th = document.createElement("th");

    th.innerHTML = des[i];
    tr.appendChild(th);
    table.appendChild(tr);
  }

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