package jpabook.jpashop;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.member.Member;

@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	@Transactional
	@Rollback(value = false)
	public void testMember() {
		// given
		Member member = new Member(null, "김용환");
		// when
		Long savedId = memberRepository.save(member);
		// then
		Member findMember = memberRepository.find(savedId);
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(member.getId()).isEqualTo(findMember.getId());
			softAssertions.assertThat(member.getUsername()).isEqualTo(findMember.getUsername());
			softAssertions.assertThat(member).isEqualTo(findMember);
			softAssertions.assertAll();
		});
	}
}
