// ==============================
// DASHBOARD SCRIPT (Library System)
// ==============================

document.addEventListener("DOMContentLoaded", () => {

    console.log("📊 Dashboard Script Loaded Successfully");

    initClock();
    initCounters();

});


// ==============================
// 1️⃣ LIVE CLOCK
// ==============================

function initClock() {

    const clockElement = document.getElementById("liveClock");

    if (!clockElement) return;

    function updateClock() {

        const now = new Date();

        const time = now.toLocaleTimeString("en-IN", {
            hour: "2-digit",
            minute: "2-digit",
            second: "2-digit"
        });

        const date = now.toLocaleDateString("en-IN", {
            weekday: "long",
            year: "numeric",
            month: "long",
            day: "numeric"
        });

        clockElement.innerHTML =
            `<i class="far fa-calendar-alt me-2"></i>${date}
             <span class="mx-2">|</span>
             <i class="far fa-clock me-2"></i>${time}`;

    }

    updateClock();
    setInterval(updateClock, 1000);

}


// ==============================
// 2️⃣ COUNTER ANIMATION
// ==============================

function initCounters() {

    startCounter("bookCounter", 150, 2000);
    startCounter("studentCounter", 50, 2000);

}

function startCounter(id, target, duration) {

    const element = document.getElementById(id);

    if (!element) return;

    let start = 0;
    const increment = target / (duration / 16);

    function update() {

        start += increment;

        if (start < target) {

            element.innerText = Math.floor(start);
            requestAnimationFrame(update);

        } else {

            element.innerText = target;

        }

    }

    update();

}