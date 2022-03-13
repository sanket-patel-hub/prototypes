import { DropdownButton } from "react-bootstrap"
import DropdownItem from "react-bootstrap/esm/DropdownItem"

export const FunctionsProvider = () => {
    return (
        <DropdownButton id="function-provider" title="Select Function" className="mt-5">
            <DropdownItem href="/click-counter">Click Counter</DropdownItem>
            <DropdownItem href="/timer">Timer</DropdownItem>
        </DropdownButton>
    )
}