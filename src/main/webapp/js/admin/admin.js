document.addEventListener('DOMContentLoaded', (event) => {
    setTimeout(function () {
        document.querySelector('.flash-text').style.display = 'none';
    }, 5000);
});

function changeImage() {

    var image = document.getElementById("images");

    var file_count = image.files.length;

    if (file_count <= 10 && file_count > 0) {

        for (var x = 0; x < 10; x++) {

            var file = image.files[x];

            if (!file) {
                var url = "images/no-image.svg";
            } else {
                var url = window.URL.createObjectURL(file);
            }


            document.getElementById("image" + x).src = url;

        }

    } else {
        alert(file_count + " files uploaded. You are allowed to upload only 10 or less than 10 images.");
    }

}