package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DisCountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DisCountPolicy discountPolicy;
    
    //@RequiredArgsConstructor 이 밑의 3줄 역할
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DisCountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
