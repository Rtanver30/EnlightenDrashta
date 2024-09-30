document.addEventListener('DOMContentLoaded', (event) => {
    let timer = 60;
    const timerElement = document.getElementById('timer');
    
    const countdown = setInterval(() => {
        if (timer > 0) {
            timer--;
            timerElement.textContent = timer;
        } else {
            clearInterval(countdown);
            alert('Time is up!');
        }
    }, 1000);

    const options = document.querySelectorAll('.option');
    options.forEach(option => {
        option.addEventListener('click', () => {
            options.forEach(opt => opt.style.backgroundColor = '#fff');
            option.style.backgroundColor = '#c8e6c9';
        });
    });

    document.querySelector('.submit-button').addEventListener('click', () => {
        let selectedOption = null;
        options.forEach(option => {
            if (option.style.backgroundColor === 'rgb(200, 230, 201)') {
                selectedOption = option.textContent;
            }
        });
        if (selectedOption) {
            alert('You selected: ' + selectedOption);
        } else {
            alert('Please select an option.');
        }
    });
});
