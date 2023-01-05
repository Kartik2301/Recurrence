const squares = document.querySelectorAll(".square");
const mole = document.querySelectorAll(".mole");
const timeLeft = document.getElementById("count-down");
const scoreTag = document.getElementById("score");

let hitPositionId;
let result = 0
let currentTime = 60;
let timerId = null;

function init() {
	for(var i=0;i<squares.length;i++) {
		squares[i].addEventListener("click", function() {
      console.log(this.id)
			if(this.id === hitPositionId) {
				result += 1
				scoreTag.textContent = result
				hitPositionId = null;
			}
		})
	}
}

init()

function pickRandomSquare() {
	squares.forEach(function(square) {
		square.classList.remove("mole");
	});

	let index = Math.floor(Math.random() * 9)
	let randomSquare = squares[index]
	randomSquare.classList.add("mole")
	hitPositionId = randomSquare.id
}

function moveMole() {
	timerId = setInterval(pickRandomSquare, 500);
}

moveMole()

function countDown() {
	currentTime--;
	timeLeft.textContent = currentTime
	if(currentTime === 0) {
    timeLeft.textContent = 0
		clearInterval(countDownTimer);
		clearInterval(timerId)
		alert("Game Over");
	}
}

let countDownTimer = setInterval(countDown, 1000);