app = (() => {
  function send() {
    let nombre = document.getElementById("name").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
      document.getElementById("userAccount").innerHTML = JSON.parse(this.responseText).arroba;
    };
    xhttp.open("GET", "/user/" + nombre);
    xhttp.send();
  }
  
  function posts() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
      document.getElementById("posts").innerHTML = JSON.stringify(JSON.parse(this.responseText).posts);
    };
    xhttp.open("GET", "/thread");
    xhttp.send();
  }
  
  function msg() {
    let mensaje = document.getElementById("message").value;
    let arroba = document.getElementById("userAccount").innerHTML;
  
    let urlPost = "/post";
    let urlHilo = "/thread";
  
    let bodyData = {
      arroba: arroba,
      mensaje: mensaje,
    };
  
    var formBody = [];
  
    for (var property in bodyData) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(bodyData[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
  
    formBody = formBody.join("&");
  
    fetch(urlPost, {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
      },
      body: formBody,
    });
  
    fetch(urlHilo, {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
      },
      body: formBody,
    }).then(posts);
  }
  
  function getAccessTokenFromUrl() {
    var fragment = window.location.hash.substring(1);
    return fragment.split("&")[0].split("=")[1];
  }


  return {
    send,
    posts,
    msg,
    getAccessTokenFromUrl,
  }
})();