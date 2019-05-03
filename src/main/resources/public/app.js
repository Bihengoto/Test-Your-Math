// timer logic
var counter = {};
window.addEventListener("load", function () {
  // COUNTDOWN IN SECONDS
  // EXAMPLE - 5 MINS = 5 X 60 = 300 SECS
  counter.end = 120;

  // Get the containers
  counter.min = document.getElementById("cd-min");
  counter.sec = document.getElementById("cd-sec");

  // Start if not past end date
  if (counter.end > 0) {
    counter.ticker = setInterval(function(){
      // Stop if passed end time
      counter.end--;
      if (counter.remain <= 0) { clearInterval(counter.ticker); }

      // Calculate remaining time
      var secs = counter.end;
      var mins  = Math.floor(secs / 60); // 1 min = 60 secs
      secs -= mins * 60;

      // Update HTML
      counter.min.innerHTML = mins;
      counter.sec.innerHTML = secs;
    }, 1000);
  }
});





//Business Logic
function summation(allQuiz1, allQuiz2, allQuiz3, allQuiz4) {
  var total = []; // created an array to place the elements in an array
  total.push(allQuiz1, allQuiz2, allQuiz3, allQuiz4); //add the elements
  var result = 0;
  for (var init = 0; init < total.length; init++) {
    result += total[init];
  }
  return result;
}

function viewInPercent(value) {
  var displayPercentage = (value / 40) * 100;
  return displayPercentage;
}

//user interface logic
$(document).ready(function() {
  $("button#start").click(function() {
    $("form#registerIn").slideDown(1000);
    $("form#registerIn").show();
  });
  $("form#registerIn").submit(function(event) {
    event.preventDefault();
    $("#registerOne").hide();
    $("#registerTwo").hide();
    $("#radio").show();
    var name = $("#fullname").val();
    var email = $("#email").val();
    $("#name").text(name);
    $("#name1").text(name);
    $(".card-title").text(name);
    $(".card-text").text(email);
  });
  $("#radio form").submit(function(event) {
    event.preventDefault();
    var answerOne = parseInt($("input:radio[name=quizOne]:checked").val());
    var answerTwo = parseInt($("input:radio[name=quizTwo]:checked").val());
    var answerThree = parseInt($("input:radio[name=quizThree]:checked").val());
    var answerFour = parseInt($("input:radio[name=quizFour]:checked").val());

    $("#radio").hide();
    $(".registerTwo").show();

    var sum = summation(answerOne, answerTwo, answerThree, answerFour); //called the function from the business logic
    var percent = viewInPercent(sum);

    $("#marks").text(percent);

    if (percent > 80) {
      $("#remarks").text("You have EXCELLENTLY passed");
    } else if (percent < 80 && percent > 50) {
      $("#remarks").text("You have FAIRLY passed");
    } else {
      $("#remarks").text("You have POORLY passed");
    }
  });
});
