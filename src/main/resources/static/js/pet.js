// 반려동물 정보 삭제 함수
async function deletePet(petId) {
    let response = await fetch(`/s/api/pet/${petId}`, {
        method: "DELETE"
    });
    let responseParse = await response.json();
    if (responseParse.code == 1) {
        alert("삭제 성공");
        location.reload(); // ajax + ssr
    } else {
        alert("삭제 실패");
    }
}