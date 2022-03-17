
# food stock requestor form with workflow

## Functional

- User of food store  create request for getting supply of specific food which required to be approved by store manager and procument manager.

## Technical

- this request is achieved by workflow enabled liferay forms.

### prerequites

#### Below data should be created in portal to test application

- one private site, for example **food portal**  here.

- Two site roles named  **Store Manager Role** and **Procurement Manager Role**

- three users

  - site user having access to create form in portal
  - site user having role "Store Manager Role association"
  - site user having role "Procurement manager Role association"

### steps to follow configure workflow for form

- add food approver workflow definition as per
  [food approver workflow](https://github.com/sanket-patel-hub/prototypes/blob/master/liferay/food%20portal/food-stock-approver-workflow.xml).

- create liferay form under site,for example with name "food stock request form" ( form can be created by importing [form lar](https://github.com/sanket-patel-hub/prototypes/blob/master/liferay/food%20portal/food-stock-requestor.portlet.lar) if you are using same liferay dxp portal as I used liferay dxp 7.2 SP3)

- configure above added/created definition for stock requestor form from its settings/configuration
