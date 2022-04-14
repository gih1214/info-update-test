package site.metacoding.userupdate.domain.user;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.userupdate.domain.pet.Pet;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class) // 이 부분 추가
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 회원가입 시 ID
    @Column(length = 20, nullable = false, unique = true)
    private String userId;

    // 유저닉네임
    @Column(length = 40, nullable = false)
    private String userName;

    // 회원가입 시 입력할 비밀번호
    // 1234 -> SHA256(해시 알고리즘) -> AB4539GDUF3AE -> 이렇게 안하면 시큐리티 거부
    @Column(length = 20, nullable = false)
    private String password;

    // 회원가입 시 받을 전화번호
    @Column(length = 60, nullable = false)
    private String phoneNum;

    // 프로필 사진 경로 저장
    @Column(length = 300)
    private String userImgurl;

    @JsonIgnoreProperties({ "user" }) // messageConverter에게 알려주는 어노테이션
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE) // 연관관계의 주인의 변수명
    private List<Pet> pets;

    // 유저정보 생성, 수정일
    @CreatedDate // insert 할때만 동작
    private LocalDateTime createDate;
    @LastModifiedDate // update 할때만 동작
    private LocalDateTime updateDate;
}
