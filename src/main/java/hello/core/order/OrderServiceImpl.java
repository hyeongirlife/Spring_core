package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// @Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy;

    // @Autowired
    // public void setMemberRepository(MemberRepository memberRepository) {
    //     System.out.println("memberRepository1111111 = " + memberRepository);
    //     this.memberRepository = memberRepository;
    // }
    //
    // @Autowired
    // public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    //     System.out.println("discountPolicy11111111 = " + discountPolicy);
    //     this.discountPolicy = discountPolicy;
    // }


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("subDiscountPolicy") DiscountPolicy discountPolicy) {
        // System.out.println("memberRepository = " + memberRepository);
        // System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 할인에 대한 도메인을 변경한다고해서 주문 도메인을 변경할 필요가 없는 설계.
        // 회원정보 조회
        Member member = memberRepository.findById(memberId);
        // 할인정책에 회원정보를 넘김
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
