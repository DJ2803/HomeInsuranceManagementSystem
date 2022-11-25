import React,{Component} from 'react';
import {render,Container} from '@testing-library/react'
import PolicyHoldercomponent from '../components/PolicyHoldercomponent';

jest.mock('../components/ViewPropertyComponent',()=>()=><div id="mockViewPropertyComponent">View Property Component</div>)
jest.mock('../components/ViewPolicyComponent',()=>()=><div id="mockViewPolicyComponent">View Policy Component </div>)
jest.mock('../components/ViewPropertyComponent',()=>()=><div id="mockViewQuoteComponent">View Policy Component</div>)

describe("mock component tests", () => {
    test("mocked components in react", () => {
    // act
    const {container} = render(< PolicyHoldercomponent />)
    // assert
   console.log(container.outerHTML)
    const mockComponent1 = container.querySelector('div#mockViewPropertyComponent')
    const mockComponent2 = container.querySelector('div#mockViewPolicyComponent')
    const mockComponent3 = container.querySelector('div#mockViewQuoteComponent')


    expect(mockComponent1).not.toBeInTheDocument()
    expect(mockComponent2).not.toBeInTheDocument()
    expect(mockComponent3).not.toBeInTheDocument()
    })
})