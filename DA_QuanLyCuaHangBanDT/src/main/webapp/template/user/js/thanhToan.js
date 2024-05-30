const btnOnlinePayment = document.getElementById('btnOnlinePayment');
const btnCashOnDelivery = document.getElementById('btnCashOnDelivery');
const paymentOptions = document.querySelector('.payment-options');

btnOnlinePayment.addEventListener('click', () => {
    paymentOptions.style.display = 'block';
});

btnCashOnDelivery.addEventListener('click', () => {
    paymentOptions.style.display = 'none';
});
