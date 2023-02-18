//Education Background row actions
document.getElementById("eduBgrndBtn").addEventListener("click", addEduBgrndRow);

function addEduBgrndRow() {
  let eduBgrndForm = document.querySelector(".eduBgrndForm");
  let row = document.querySelector(".edu-bgrnd-row").cloneNode(true);

  let button = document.getElementById("eduBgrndBtn");
  eduBgrndForm.append(row);
}
