
function loadData() {
    var xhr = new XMLHttpRequest();
    var serviceKey =
        "xiHxcGDtInUZCQye8H1B3U9nLV7PRYtAOVUzMRVkJyxvNsdVkK0ZVCyt%2FyMVUZCKnwRuFfAaGjlhDOEFN8l%2FOg%3D%3D";
    const heroku = "https://cors-anywhere.herokuapp.com/";
    var url =
        "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade"; /*URL*/
    var queryParams =
        "?" + encodeURIComponent("serviceKey") + "=" + serviceKey; /*Service Key*/
    queryParams +=
        "&" +
        encodeURIComponent("LAWD_CD") +
        "=" +
        encodeURIComponent("11110"); /**/
    queryParams +=
        "&" +
        encodeURIComponent("DEAL_YMD") +
        "=" +
        encodeURIComponent("201512"); /**/
    
        // fetch(heroku + url + queryParams,  { method: "GET" }).then((response) => response.text()).then((data) => console.log(data));
    
    
    xhr.open("GET", heroku + url + queryParams);
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            makeParsingApt(this.responseText);
        }
    };

    xhr.send("");

}

function makeParsingApt(data) {
    let bookList = document.querySelector("#item_div");
    let parser = new DOMParser();
    const xml = parser.parseFromString(data, "application/xml");
    
    let items = xml.querySelectorAll("item");

    items.forEach((item) => {
        let aptName = item.querySelector("아파트").textContent;
        let price = item.querySelector("거래금액").textContent;
        let buildYear = item.querySelector("건축년도").textContent;
        let transYear = item.querySelector("년").textContent;
        let transMonth = item.querySelector("월").textContent;
        let dong = item.querySelector("법정동").textContent;
        let dongAddress = dong + " " + item.querySelector("지번").textContent;
        // let doro = item.querySelector("도로명").textContent;
        let doroAddress = dong + " " + item.querySelector("도로명건물본번호코드").textContent;
        let doroCode = item.querySelector("도로명시군구코드").textContent;
        let dongCode = item.querySelector("법정동읍면동코드").textContent;
        let size = item.querySelector("전용면적").textContent;
        let floor = item.querySelector("층").textContent;

        console.log(aptName + " " + price + " " + buildYear + " " + transYear + " " + transMonth + " " + dong + " " + dongAddress
            + " " + doro + " " + doroAddress + " " + doroCode + " " + dongCode + " " + size + " " +  floor);
        // let divAround = document.createElement("div");
        // divAround.setAttribute("class", "col-md-3 border border-secondary rounded pt-2 pb-2");

        // let divImage = document.createElement("div");
        // divImage.setAttribute("class", "mt-1");

        // let image = document.createElement("img");
        // image.setAttribute("src", `img/book/${book.querySelector("isbn").textContent}.png`);
        // image.setAttribute("class", "rounded w-100");

        // let divLabel = document.createElement("div");
        // divLabel.setAttribute("class", "mt-1 p-1 text-center");
        // divLabel.setAttribute("style", "background-color: #f2f2f2;");

        // let label1 = document.createTextNode(`${book.querySelector("title").textContent}`);
        // let label2 = document.createTextNode(`(${Intl.NumberFormat().format(book.querySelector("price").textContent)}원)`);

        // divLabel.append(document.createElement("br"));
        // divLabel.appendChild(label1);
        // divLabel.append(document.createElement("br"));
        // divLabel.appendChild(label2);

        
        // divImage.appendChild(image);
        // divAround.appendChild(divImage);
        // divAround.appendChild(divLabel);

        // bookList.appendChild(divAround);
    });

    
}

loadData()